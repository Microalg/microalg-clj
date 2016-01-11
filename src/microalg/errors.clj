(ns microalg.errors)

(def afficher-sans-arg
  "`Afficher` prend un paramètre, mais vous n’en donnez aucun.")
(def afficher-trop-args
  (str "`Afficher` n’a qu’un paramètre, "
       "faites plusieurs affichages ou utilisez `Concatener`."))