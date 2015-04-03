(ns saveprincess.core (:gen-class)
  (:require [clojure.string :as str]))

(defn next-step-to-the-princess [s me grid]
  (let [p  (.indexOf grid "p") ;; princess
        pr (quot p s)  ;; princess row
        pc (rem p s)   ;; princess col
        mr (first me)  ;; me row
        mc (second me) ;; me col
        rd (- pr mr)   ;; distance
        cd (- pc mc)   ;; distance
        rm (if (pos? rd) "DOWN"  "UP")   ;; row move direction
        cm (if (pos? cd) "RIGHT" "LEFT") ;; col move direction
        nm (if (not= rd 0) rm cm) ;; next move
        ]
    nm))

(defn -main []
  (let [size (read-string (read-line))
        me   (map (fn [x] (Integer. (str x))) (seq (str/replace (read-line) " " "")))
        grid (str/replace (slurp *in*) "\n" "")]
    (println (next-step-to-the-princess size me grid))))

(if (not (System/getProperty "hasmain")) (-main))
