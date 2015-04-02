(ns saveprincess.grid)

(defn four-corners-of-a-square [size]
  [0
   (- size 1)
   (* size (- size 1))
   (- (* size size) 1)])

(defn square-with-me-in-the-center [size]
  (assoc (vec (repeat (* size size) "-"))
         (/ (- (* size size) 1) 2)
         "m"))

(defn generate-grid
  ([size]
    (assoc (vec (square-with-me-in-the-center size))
           (rand-nth (four-corners-of-a-square size))
           "p"))
  ([size peach-pos]
    (let [corners {:top-left     0
                   :top-right    1
                   :bottom-left  2
                   :bottom-right 3}]
      (assoc (vec (square-with-me-in-the-center size))
             (get (four-corners-of-a-square size) (get corners peach-pos))
             "p"))))
