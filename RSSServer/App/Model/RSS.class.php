<?php

namespace App\Model;

/**
 * Entity that represents RSS document.
 */
class RSS {
    
    /**
     * Document Object Model for RSS
     * @var \DOMDocument
     */
    private $dom;
    
    /**
     * Constructs a new instance of RSS.
     * @param \DOMDocument $dom
     */
    public function __construct($dom) {
        $this->dom = $dom;
    }
    
    /**
     * Getter of dom attribute.
     * @return \DOMDocument
     */
    public function getDom() {
        return $this->dom;
    }
    
}
