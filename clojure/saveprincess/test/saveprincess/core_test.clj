(ns saveprincess.core-test
  (:require [clojure.test :refer :all]
            [saveprincess.grid :refer :all]
            [saveprincess.core :refer :all]))

(deftest four-corners-of-a-square-test
  (testing "a 3x3 square"
    (is (= (four-corners-of-a-square 3) [0 2 6 8])))
  (testing "a 5x5 square"
    (is (= (four-corners-of-a-square 5) [0 4 20 24])))
  (testing "a 7x7 square"
    (is (= (four-corners-of-a-square 7) [0 6 42 48]))))

(deftest square-with-me-in-the-center-test 3
  (testing "a 3x3 square"
    (is (= (square-with-me-in-the-center 3) ["-" "-" "-"
                                             "-" "m" "-"
                                             "-" "-" "-"])))
  (testing "a 3x3 square"
    (is (= (square-with-me-in-the-center 5) ["-" "-" "-" "-" "-"
                                             "-" "-" "-" "-" "-"
                                             "-" "-" "m" "-" "-"
                                             "-" "-" "-" "-" "-"
                                             "-" "-" "-" "-" "-"]))))

(deftest generate-grid-test
  (testing "a 3x3 square with peach on the top right"
    (is (= (generate-grid 3 :top-right) ["-" "-" "p"
                                         "-" "m" "-"
                                         "-" "-" "-"])))
  (testing "a 5x5 square with peach on the bottom left"
    (is (= (generate-grid 5 :bottom-left) ["-" "-" "-" "-" "-"
                                           "-" "-" "-" "-" "-"
                                           "-" "-" "m" "-" "-"
                                           "-" "-" "-" "-" "-"
                                           "p" "-" "-" "-" "-"])))
  (testing "a 3x3 square with peach in some random corner"
    (let [grid (generate-grid 3)]
      (or (= grid ["p" "-" "-"
                   "-" "m" "-"
                   "-" "-" "-"])
          (= grid ["-" "-" "p"
                   "-" "m" "-"
                   "-" "-" "-"])
          (= grid ["-" "-" "-"
                   "-" "m" "-"
                   "p" "-" "-"]
          (= grid ["-" "-" "-"
                   "-" "m" "-"
                   "-" "-" "p"]))))))

(deftest move-test
  (testing "princess is above me"
    (is (= (move :y 1 0) "UP")))
  (testing "princess is below me"
    (is (= (move :y 1 2) "DOWN")))
  (testing "princess is at my left"
    (is (= (move :x 1 0) "LEFT")))
  (testing "princess is at my right"
    (is (= (move :x 1 2) "RIGHT"))))

(deftest path-to-princess-test
  (testing "princess is on the top left"
    (let [size 3
          grid (generate-grid size :top-left)]
      (is (= (path-to-princess size grid) '("LEFT" "UP")))))
  (testing "princess is on the top right"
    (let [size 5
          grid (generate-grid size :top-right)]
      (is (= (path-to-princess size grid) '("RIGHT" "RIGHT" "UP" "UP")))))
  (testing "princess is on the bottom left"
    (let [size 7
          grid (generate-grid size :bottom-left)]
      (is (= (path-to-princess size grid) '("LEFT" "LEFT" "LEFT" "DOWN" "DOWN" "DOWN")))))
  (testing "princess is on the bottom right"
    (let [size 3
          grid (generate-grid size :bottom-right)]
      (is (= (path-to-princess size grid) '("RIGHT" "DOWN"))))))
