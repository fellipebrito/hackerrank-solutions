(ns sudoku.core (:gen-class)
  (require [clojure.string :as str]))

(defn has-duplicates? [group]
  (not= (count (set group)) 9))

(defn valid-group? [group]
  (and (false? (has-duplicates? group))
       (= (reduce + (map #(Character/digit % 10) group)) 45)))

(defn columns [rows]
  [(apply str (map #(nth % 0) rows))
   (apply str (map #(nth % 1) rows))
   (apply str (map #(nth % 2) rows))
   (apply str (map #(nth % 3) rows))
   (apply str (map #(nth % 4) rows))
   (apply str (map #(nth % 5) rows))
   (apply str (map #(nth % 6) rows))
   (apply str (map #(nth % 7) rows))
   (apply str (map #(nth % 8) rows))])

(defn rip-the-puzzle [puzzle]
  (let [rows (re-seq #".{1,9}" puzzle)]
    {:rows (into [] rows)
     :cols (columns rows)}))

(defn -main
  [& args]
  (let [size    (read-string (read-line))
        puzzles (re-seq #".{1,81}" (str/replace (str/replace (slurp *in*) "\n" "") " " ""))]
    (if (and (every? true?
                     (map valid-group? (:rows (rip-the-puzzle (first puzzles)))))
             (every? true?
                     (map valid-group? (:cols (rip-the-puzzle (first puzzles))))))
      (println "Valid")
      (println "Invalid")
      )))

(if (not (System/getProperty "hasmain")) (-main))
