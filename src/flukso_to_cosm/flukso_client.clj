(ns flukso-to-cosm.flukso-client (:require [clj-http.client :as client]))
(defn query_to_parm [query]
  (apply str (interpose "&" (map #(str (name (first %)) "=" (second %)) query)))
  )
(defn get_full_url [url query] 
  (str url "?" (query_to_parm query))
  )
(defn get-data [url query headers]
  (:body (client/get (get_full_url url query) {:insecure? true :headers headers :accept :json} ))
)
