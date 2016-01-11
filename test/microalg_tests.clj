(ns microalg_tests
  (:require [microalg.lang :refer :all]
            [microalg.errors :as erreur])
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
; Erreurs
(deftest affichage_sans_arg []
  (is (thrown-with-msg? Exception (re-pattern erreur/afficher-sans-arg)
    (Afficher))))
(deftest affichage_trop_args []
  (is (thrown-with-msg? Exception (re-pattern erreur/afficher-trop-args)
    (Afficher "tavu" "ou bien"))))
