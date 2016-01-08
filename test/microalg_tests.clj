(ns microalg_tests
  (:require [microalg.lang :refer :all])
  (:use clojure.test))

(deftest version_number []
  (is (= "0.0.1" version)))

; Affichage
(deftest affichage_bonjour_last []
  (with-out-str (Afficher "Bonjour tout le monde !"))
  (is (= "Bonjour tout le monde !" *LastStdOut)))
(deftest affichage_vide_last []
  (with-out-str (Afficher ""))
  (is (= "" *LastStdOut)))
(deftest affichage_double_last []
  (with-out-str (Afficher "Un"))
  (with-out-str (Afficher "Deux"))
  (is (= "Deux" *LastStdOut)))
