<?php

namespace App\Controller;

use App\Persistence\RSSDAO;
use App\Http\ResponseXml;

/**
 * Controller for RSS.
 */
class RSSController {
    
    /**
     * Generates the RSS document.
     * @return ResponseXml
     */
    public function generateRSS () {
        
        $dao = new RSSDAO();
        $rssDocument = $dao->getDocument();
        
        return new ResponseXml($rssDocument);
       
    }
    
}
