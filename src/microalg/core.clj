(ns microalg.core
  (:require microalg.lang
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

(defn execute-dot-malg
  [file]
  (binding [*ns* (find-ns 'microalg.lang)]
    (eval (read-string (slurp file)))))

(defn -main
  [& args]
  (if (empty? args)
    (org.dipert.swingrepl.main/make-repl-jframe
      {:on-close javax.swing.JFrame/EXIT_ON_CLOSE
       :init my-init
       :eval my-eval})
    (execute-dot-malg (nth args 0))))
