package com.wahid.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*


fun Application.configureStatusPages() {
    install(StatusPages)
    {
        status(HttpStatusCode.NotFound)
        { applicationCall, httpStatusCode ->
            applicationCall.respond(
                httpStatusCode,
                message = """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404 Not Found</title>
    <style>
        body {
            background-color: #f4f4f4; /* Light gray background color */
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            text-align: center;
            background-color: #ffffff; /* White background for the content box */
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            font-size: 48px;
            color: #333333; /* Dark gray text color */
            margin-bottom: 20px;
        }
        p {
            font-size: 18px;
            color: #666666; /* Medium gray text color */
            margin-bottom: 30px;
        }
        a {
            text-decoration: none;
            color: #007BFF; /* Blue link color */
            font-weight: bold;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>404</h1>
        <p>Oops! The page you're looking for doesn't exist.</p>
        <a href="/">Go back to the homepage</a>
    </div>
</body>
</html>""".trimIndent()
            )
        }
    }
}