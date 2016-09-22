<?php

namespace App\Http;
/**
 * Class to reply XML documents.
 */
class ResponseXml extends Response {
    
    /**
     * Holds the RSS document.
     * @var RSS
     */
    private $document;
    
    /**
     * Constructs a new instance of ResponseXml
     * @param RSS $document
     */
    public function __construct($document) {
        $this->document = $document;
    }
    
    public function reply() {
        header("Content-Type: application/xml; charset=UTF-8");
        echo $this->document->getDom()->saveXML();
    }

}
