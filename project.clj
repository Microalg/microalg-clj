(defproject microalg "0.0.1-SNAPSHOT"
  :description "Clojure implementation of the MicroAlg language."
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [uk.org.russet/swingrepl "1.4.1-SNAPSHOT"
                  :exclusions [org.clojure/clojure org.clojure/clojure-contrib]]]
  :javac-options ["-target" "1.6" "-source" "1.6" "-Xlint:-options"]
  :aot [microalg.core]
  :main microalg.core
  :repl-options {:prompt (fn [ns] ": ")
                 :welcome (println "MicroAlg-clj 0.0.1")
                 :init-ns microalg.lang})
