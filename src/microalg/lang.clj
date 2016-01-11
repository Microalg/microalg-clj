(ns microalg.lang
  (:require [microalg.errors :as erreur]))

(def ^{:const true}
  version "0.0.1")

(def Rien 'Rien)
(def *LastStdOut "")

(defn Afficher
  [& args]
  (if (empty? args)
    (throw (Exception. erreur/afficher-sans-arg)))
  (if (not= 1 (count args))
    (throw (Exception. erreur/afficher-trop-args)))
  (let [!a_afficher (nth args 0)]
    (println !a_afficher)
    (def *LastStdOut !a_afficher)
    Rien))
