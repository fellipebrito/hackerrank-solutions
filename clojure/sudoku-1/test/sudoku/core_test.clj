(ns sudoku.core-test
  (:require [clojure.test :refer :all]
            [clojure.string :as str]
            [sudoku.core :refer :all]))

(def valid-puzzle
  (str/replace "5 3 4 6 7 8 9 1 2 6 7 2 1 9 5 3 4 8 1 9 8 3 4 2 5 6 7 8 5 9 7 6 1 4 2 3 4 2 6 8 5 3 7 9 1 7 1 3 9 2 4 8 5 6 9 6 1 5 3 7 2 8 4 2 8 7 4 1 9 6 3 5 3 4 5 2 8 6 1 7 9" " " ""))

(def invalid-puzzle
  (str/replace "5 5 4 6 7 8 9 1 2 6 7 2 1 9 5 3 4 8 1 9 8 3 4 2 5 6 7 8 5 9 7 6 1 4 2 3 4 2 6 8 5 3 7 9 1 7 1 3 9 2 4 8 5 6 9 6 1 5 3 7 2 8 4 2 8 7 4 1 9 6 3 5 3 4 5 2 8 6 1 7 9" " " ""))

(deftest rip-the-puzzle-test
  (testing "a puzzle has 9 rows"
    (is (= (count (:rows (rip-the-puzzle valid-puzzle))) 9)))
  (testing "a puzzle has 9 cols"
    (is (= (count (:cols (rip-the-puzzle valid-puzzle))) 9))))

(deftest valid-group-test
  (testing "a valid group"
    (is (true? (valid-group? (apply str (shuffle (range 1 10)))))))
  (testing "an invalid group"
    (is (false? (valid-group? "112345678")))))

(defn grid [cols rows]
  [(apply str [(nth (nth rows 0) 0) (nth (nth rows 0) 1) (nth (nth rows 0) 2)
               (nth (nth rows 1) 0) (nth (nth rows 1) 1) (nth (nth rows 1) 2)
               (nth (nth rows 2) 0) (nth (nth rows 2) 1) (nth (nth rows 2) 2)
               ])])

(grid (:cols (rip-the-puzzle valid-puzzle)) (:rows (rip-the-puzzle valid-puzzle)))
