(ns microalg.lang
  (:refer-clojure :exclude [= > >= < <=])
  (:require [microalg.errors :as erreur]))

(def ^{:const true}
  version "0.0.1")

(def Rien 'Rien)
(def Vrai 'Vrai)
(def Faux 'Faux)
(def *LastStdOut "")
(def *var-map {})

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

(defn =
  [x y]
  (if (clojure.core/= x y) Vrai Faux))
(defn n=
  [x y]
  (if (clojure.core/not= x y) Vrai Faux))
(defn <
  [x y]
  (if (clojure.core/< x y) Vrai Faux))
(defn <=
  [x y]
  (if (clojure.core/<= x y) Vrai Faux))
(defn >
  [x y]
  (if (clojure.core/> x y) Vrai Faux))
(defn >=
  [x y]
  (if (clojure.core/>= x y) Vrai Faux))

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

(defmacro Declarer
  [var De_type type]
  `(do
    (if (contains? *var-map (quote ~var))
      (erreur/declarer-deja-declaree (quote ~var) (*var-map (quote ~var))))
    (alter-var-root (var *var-map) assoc (quote ~var) ~type)
    (def ~var Rien)
    Rien))

(defmacro Affecter_a
  [var val]
  `(do
    (if-not (contains? *var-map (quote ~var))
      (erreur/affecter_a-non-declaree (quote ~var)))
    (def ~var ~val)
    Rien))
