<?php

namespace App\Persistence;


use App\Persistence\Connection;
use App\Model\RSS;

/**
 * Provides database interaction for RSS.
 */
class RSSDAO {
    
    /**
     * Store the connection resource.
     * @var \PDO
     */
    private $connection;
    
    public function __construct() {
        $this->connection = Connection::getConnection();
    }
    
    /**
     * Returns a rss document with channel and items.
     * @return RSS
     */
    public function getDocument() {
        
        $document = new \DOMDocument();
        
        $rss = $document->createElement("rss");
        $rss->setAttribute("version", "2.0");
        
        $channel = $document->createElement("channel");
        
        $sql = "SELECT * FROM rss_channel ORDER BY id DESC LIMIT 1";
        $st = $this->connection->prepare($sql);
        $st->execute();
        
        $row = $st->fetch(\PDO::FETCH_ASSOC);
        
        $channelElements = [];
        $excludedElements = ["id", "image_link", "image_url", "image_title"];
        
        foreach ($row as $column => $value) {
            if (!in_array($column, $excludedElements)) {                
                $channelElements[] = $document->createElement($column, htmlspecialchars($value));
            }
        }
        
        $image = $document->createElement("image");
        $imageUrl = $document->createElement("url", $row["image_url"]);
        $imageLink = $document->createElement("link", htmlspecialchars($row["image_link"]));
        $imageTitle = $document->createElement("title", $row["image_title"]);
        
        $image->appendChild($imageUrl);
        $image->appendChild($imageLink);
        $image->appendChild($imageTitle);
        
        $channelElements[] = $image;
        
        $channelElements = array_merge($channelElements, $this->getItems($document));
        
        foreach ($channelElements as $element) {
            $channel->appendChild($element);
        }
        
        $rss->appendChild($channel);
        $document->appendChild($rss);
        
        $rssDocument = new RSS($document);
        
        return $rssDocument;
        
    }
    
    /**
     * Get items from database
     * @param \DOMDocument $document
     * @return array
     */
    private function getItems ($document) {
        
        $sql = "SELECT * FROM rss_itens";
        $st = $this->connection->prepare($sql);
        $st->execute();
        
        $rows = $st->fetchAll(\PDO::FETCH_ASSOC);
        
        $items = [];
        
        foreach ($rows as $row) {
            
            $item = $document->createElement("item");
            
            foreach ($row as $column => $value) {
                if ($column != "id") {
                    $itemElement = $document->createElement($column, htmlspecialchars($value));
                    $item->appendChild($itemElement);
                }
            }
           
            $items[] = $item;
            
        }
        
        return $items;
        
    }
    
}
