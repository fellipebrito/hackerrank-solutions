(ns saveprincess.core (:gen-class)
  (:require [clojure.string :as str]))

(defn move [axis my-pos p-pos]
  (if (= :y axis) (if (< my-pos p-pos) "DOWN" "UP")
                  (if (< my-pos p-pos) "RIGHT" "LEFT")))

(defn path-to-princess [size grid]
  (let [my-pos (.indexOf grid "m")
        p-pos  (.indexOf grid "p")
        distance  (/ (- size 1) 2)]
    (concat (repeat distance (move :x (rem my-pos size) (rem p-pos size)))
            (repeat distance (move :y (int (/ my-pos size)) (int (/ p-pos size)))))))

(defn -main []
  (let [size (read-string (read-line))
        grid (str/replace (slurp *in*) "\n" "")]
    (println (str/join "\n" (path-to-princess size grid)))))

(if (not (System/getProperty "hasmain")) (-main))
