(defproject cheshire-cat "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.6.0"]
                 [ring/ring-defaults "0.3.1"]
                 [ring/ring-json "0.4.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [cljs-http "0.1.45"]
                 [org.clojure/core.async "0.4.474"]
                 [enfocus "2.1.1"]]
  :plugins [[lein-ring "0.12.4"]
            [lein-cljsbuild "1.1.7"]]
  :ring {:handler cheshire-cat.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}}
  :cljsbuild {
               :builds [{
                          :source-paths ["src-cljs"]
                          :compiler {
                                      :output-to "resources/public/main.js"
                                      :optimizations :whitespace
                                      :pretty-print true}}]})
