(ns microalg.core
  (:import (java.io PushbackReader))
  (:require microalg.lang
            [clojure.java.io :as io]
            clojure.main
            org.dipert.swingrepl.main)
  (:gen-class))

(defn my-eval
  [code]
  (let [!result (eval code)]
    (if (= nil !result)
      "-> nil"
      (str "-> " !result))))

(defn my-init
  []
  (println (str "MicroAlg-clj " microalg.lang/version))
  (in-ns 'microalg.lang))

(defn read-all
  "http://stackoverflow.com/questions/24922478/is-there-a-way-to-read-all-the-forms-in-a-clojure-file#24922859"
  [file]
  (let [rdr (-> file io/file io/reader PushbackReader.)]
    (loop [forms []]
      (let [form (try (read rdr) (catch Exception e nil))]
        (if form
          (recur (conj forms form))
          forms)))))

(defn execute-dot-malg
  [file]
  (binding [*ns* (find-ns 'microalg.lang)]
    (eval (read-all file))))

(defn -main
  [& args]
  (if (empty? args)
    (org.dipert.swingrepl.main/make-repl-jframe
      {:on-close javax.swing.JFrame/EXIT_ON_CLOSE
       :init my-init
       :eval my-eval})
    (execute-dot-malg (nth args 0))))
