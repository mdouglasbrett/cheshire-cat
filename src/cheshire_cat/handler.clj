(ns cheshire-cat.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :as ring-json]
            [ring.util.response :as rr]))

(defroutes app-routes
  (GET "/" [] "Hello World, this is a clojure app running in a docker container")
  (GET "/cheshire-cat" []
       (rr/response {:name "Cheshire Cat" :status :grinning}))
  (route/not-found "Not found"))

(def app
  (-> app-routes
      (ring-json/wrap-json-response)
      (wrap-defaults site-defaults)))
