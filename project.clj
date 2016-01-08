(defproject microalg "0.0.1-SNAPSHOT"
  :description "Clojure implementation of the MicroAlg language."
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :javac-options ["-target" "1.6" "-source" "1.6" "-Xlint:-options"]
  :aot [microalg.core]
  :main microalg.core)
