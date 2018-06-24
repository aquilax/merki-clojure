(defproject merki "0.1.0-SNAPSHOT"
  :description "Command line quantity tracker in Clojure"
  :url "https://github.com/aquilax/merki-clojure"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot merki.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
