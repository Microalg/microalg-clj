(ns microalg.errors)

(defn- quit
  ([msg] (throw (Exception. msg)))
  ([msg & [value]] (throw (Exception. (str value " -- " msg)))))

(def afficher-sans-arg
  "`Afficher` prend un paramètre, mais vous n’en donnez aucun.")
(def afficher-trop-args
  (str "`Afficher` n’a qu’un paramètre, "
       "faites plusieurs affichages ou utilisez `Concatener`."))
(defn declarer-deja-declaree
  [var type]
  (quit (str "`Declarer` : la variable `" var "` a déjà été déclarée "
             "de type `" type "`.")))
(defn affecter_a-non-declaree
  [var]
  (quit "Variable non déclarée." var))