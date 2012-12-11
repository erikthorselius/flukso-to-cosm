(ns flukso-to-cosm.handler
  (:use compojure.core 
        ring.adapter.jetty)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [flukso-to-cosm.fetcher :as fetcher])
  )

(defroutes app-routes
  (GET "/" [] (fetcher/get-data))
  (GET "/hi/:name" [name] (str "<p>Hi " name))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main [port]
  (run-jetty app {:port (Integer. port)}))

