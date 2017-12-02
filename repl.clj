(require
         '[cljs.repl :as repl]
         '[cljs.repl.rhino :as rhino])

(repl/repl* (rhino/repl-env)
            {
             :source-paths ["src-cljs"]
             :compiler {
                        :output-to "resources/public/main.js"
                        :optimizations :whitespace
                        :pretty-print :true}
             })
