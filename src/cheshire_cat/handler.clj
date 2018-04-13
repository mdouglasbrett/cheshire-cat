(ns cheshire-cat.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :as ring-json]
            [ring.util.response :as rr]
            [cheshire.core :as json]))

(defroutes app-routes
  (GET "/" [] "Hello World, this is a clojure app running in a docker container")
  (GET "/cheshire-cat" []
       {:status 200
        :headers {"Content-Type" "application/json; charset=utf-8"}
        :body (json/generate-string
               {:name "Cheshire Cat"
                :status :grinning})})
  (route/not-found "Not found"))

(def app
  (-> app-routes
      (ring-json/wrap-json-response)
      (wrap-defaults site-defaults)))
