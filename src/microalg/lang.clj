(ns microalg.lang
  (:require [microalg.errors :as erreur]))

(def ^{:const true}
  version "0.0.1")

(def Rien 'Rien)
(def Vrai 'Vrai)
(def Faux 'Faux)
(def *LastStdOut "")

(defmulti #^{:private true} !text class)
(defmethod !text java.lang.String
  [arg]
  arg)
(defmethod !text java.lang.Long
  [arg]
  (str arg))
(defmethod !text clojure.lang.Symbol
  [arg]
  (str arg))

(defn Afficher
  [& args]
  (if (empty? args)
    (throw (Exception. erreur/afficher-sans-arg)))
  (if (not= 1 (count args))
    (throw (Exception. erreur/afficher-trop-args)))
  (let [!a_afficher (!text (nth args 0))]
    (println !a_afficher)
    (def *LastStdOut !a_afficher)
    Rien))

(defn Texte
  [& args]
  (!text (nth args 0)))