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
; Manque (Afficher Afficher)
(deftest affichage_Vrai []
  (with-out-str (Afficher Vrai))
  (is (= "Vrai" *LastStdOut)))
(deftest affichage_Faux []
  (with-out-str (Afficher Faux))
  (is (= "Faux" *LastStdOut)))
(deftest affichage_var []
  (def x 0)
  (with-out-str (Afficher x))
  (is (= "0" *LastStdOut)))
(deftest affichage_simple_eval []
  (with-out-str (Afficher (do (def x (+ x 1)) x))
  (is (= 1 x))))

; Erreurs
(deftest affichage_sans_arg []
  (is (thrown-with-msg? Exception (re-pattern erreur/afficher-sans-arg)
    (Afficher))))
(deftest affichage_trop_args []
  (is (thrown-with-msg? Exception (re-pattern erreur/afficher-trop-args)
    (Afficher "tavu" "ou bien"))))

; Texte
(deftest texte_texte []
  (is (= "0" (Texte "0"))))
(deftest texte_nombre []
  (is (= "0" (Texte 0))))
(deftest texte_vrai []
  (is (= "Vrai" (Texte Vrai))))
(deftest texte_faux []
  (is (= "Faux" (Texte Faux))))
(deftest texte_rien []
  (is (= "Rien" (Texte Rien))))
