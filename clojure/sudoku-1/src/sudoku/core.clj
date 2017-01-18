(ns sudoku.core (:gen-class)
  (require [clojure.string :as str]))

(defn has-duplicates? [group]
  (not= (count (set group)) 9))

(defn valid-group? [group]
  (and (false? (has-duplicates? group))
       (= (reduce + (map #(Character/digit % 10) group)) 45)))

(defn rip-the-puzzle [puzzle]
  {:rows (re-seq #".{1,9}" puzzle)})

(defn -main
  [& args]
  (let [size    (read-string (read-line))
        puzzles (re-seq #".{1,81}" (str/replace (str/replace (slurp *in*) "\n" "") " " ""))]
    (if (every? true?
                (map valid-group? (:rows (rip-the-puzzle (first puzzles)))))
      (println "Valid")
      (println "Invalid")
      )))

(if (not (System/getProperty "hasmain")) (-main))
