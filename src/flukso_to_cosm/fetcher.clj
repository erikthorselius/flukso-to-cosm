(ns flukso-to-cosm.fetcher
  (:require [flukso-to-cosm.flukso-client :as client]
            ))
(defn get-data []
  (client/get-data (apply str (interpose \/ ["https://api.flukso.net/sensor" "1b1aa50f878e95620e112c48ba738e0f"])) 
                   {:interval "hour" :unit "watt"} 
                   {"X-Token" "799c53a8bbc537d2eb042c057a19cbe4" "X-Version" "1.0"}) 
  )

