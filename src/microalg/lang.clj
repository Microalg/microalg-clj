(ns microalg.lang)

(def ^{:const true}
  version "0.0.1")

(def Rien 'Rien)
(def *LastStdOut "")

(defn Afficher
  [& args]
  (let [!a_afficher (nth args 0)]
    (println !a_afficher)
    (def *LastStdOut !a_afficher)
    Rien))
