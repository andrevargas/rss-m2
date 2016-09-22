<?php

namespace App\Http;

/**
 * @abstract
 * Abstract class that represents HTTP response.
 */
abstract class Response {
    
    /**
     * @abstract
     * Executes response content.
     */
    public abstract function reply();
    
}
