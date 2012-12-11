(ns flukso-to-cosm.handler
  (:use compojure.core 
        ring.adapter.jetty)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/hi/:name" [name] (str "<p>Hi " name))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main [port]
  (run-jetty app {:port (Integer. port)}))

