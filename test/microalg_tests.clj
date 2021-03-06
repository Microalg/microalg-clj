(ns microalg_tests
  (:refer-clojure :exclude [= > >= < <=])
  (:require [microalg.lang :refer :all]
            [microalg.errors :as erreur])
  (:use clojure.test))

(deftest version_number []
  (is (= "0.0.1" version)))

; Comparaisons
(deftest comp-= []
  (is (and (= Vrai (= 1 1)) (= Faux (= 2 1)))))
(deftest comp-n= []
  (is (and (= Vrai (n= 1 2)) (= Faux (n= 1 1)))))
(deftest comp-< []
  (is (and (= Vrai (< 1 2)) (= Faux (< 2 1)))))
(deftest comp-<= []
  (is (and (= Vrai (<= 1 1)) (= Vrai (<= 1 2)) (= Faux (<= 2 1)))))
(deftest comp-> []
  (is (and (= Vrai (> 1 1)) (= Vrai (> 1 2)) (= Faux (> 2 1)))))
(deftest comp->= []
  (is (and (= Vrai (>= 1 1)) (= Faux (>= 1 2)) (= Vrai (>= 2 1)))))

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

; Déclaration et Affectation
(deftest declaration-affectation []
  (Declarer x De_type "nombre")
  (Affecter_a x 0)
  (is (= 0 x)))

; Erreurs
(deftest double-declaration []
  (is (thrown-with-msg? Exception (re-pattern
       "^`Declarer` : la variable `x` a déjà été déclarée de type `nombre`\\.$")
    (Declarer x De_type "nombre")
    (Declarer x De_type "nombre"))))
(deftest affectation-sans-declaration []
  (is (thrown-with-msg? Exception (re-pattern "^x -- Variable non déclarée.$")
    (Affecter_a x 0))))
