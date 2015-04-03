(ns saveprincess.grid)

(defn square-with-me
  ([size]
    (assoc (vec (repeat (* size size) "-"))
           (rand-int(- (* size size) 1))
           "m"))
 ([size pos]
    (assoc (vec (repeat (* size size) "-"))
           pos
           "m")))

(defn generate-grid
  ([size]
    (assoc (vec (square-with-me size))
           (rand-int(- (* size size) 1))
           "p"))
  ([size my-pos]
    (assoc (vec (square-with-me size my-pos))
           (rand-int(- (* size size) 1))
            "p"))
  ([size my-pos peach-pos]
    (assoc (vec (square-with-me size my-pos))
            peach-pos
            "p")))
