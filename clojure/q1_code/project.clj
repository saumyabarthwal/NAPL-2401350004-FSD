;

(defproject q1_code "0.1.0-SNAPSHOT"
  :description "Clojure Assignment"
  :url "https://example.com/q1_code"
  :license {:name "EPL-2.0"}

  :dependencies [[org.clojure/clojure "1.12.2"]
                 [com.github.seancorfield/next.jdbc "1.3.939"]
                 [org.xerial/sqlite-jdbc "3.45.1.0"]
                 [ring/ring-core "1.12.2"]
                 [ring/ring-jetty-adapter "1.12.2"]]

  :main ^:skip-aot q1_code.core
  :target-path "target/%s"

  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
