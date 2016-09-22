<?php

use App\Controller\RSSController;
use App\Http\Response;

    ini_set('display_errors', 1);
    ini_set('display_startup_errors', 1);
    error_reporting(E_ALL);

    require_once 'autoload.php';

    $controller = new RSSController();

    $action = $controller->generateRSS();

    if ($action instanceof Response) {
        $action->reply();
    }
