<?php

namespace App\Persistence;

/**
 * Provides singleton connection.
 */
class Connection {
    
    const HOST = "localhost";
    const PORT = "3306";
    const DATABASE_NAME = "trabalho_rss";
    const USER = "root";
    const PASSWORD = "";
    
    /**
     * Holds the unique instance connection.
     * @var \PDO 
     */
    private static $connection;
    
    /**
     * Create a new connection if not exists.
     * @return \PDO
     */
    public static function getConnection () {
        
        if (self::$connection == null) {
            $connectionString = "mysql:host=" . self::HOST . ";port=" . self::PORT . ";dbname=" . self::DATABASE_NAME;
            self::$connection = new \PDO($connectionString, self::USER, self::PASSWORD);
        }
        
        return self::$connection;
        
    }
    
}