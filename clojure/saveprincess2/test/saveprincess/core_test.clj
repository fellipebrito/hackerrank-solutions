(ns saveprincess.core-test
  (:require [clojure.test :refer :all]
            [saveprincess.grid :refer :all]
            [saveprincess.core :refer :all]))

(deftest square-with-me-test
  (testing "asserting the user is in any place of a random size square"
    (is (> (.indexOf (square-with-me (rand-int 11)) "m") -1)))
  (testing "asserting the user is in a exactly place of a random size square"
    (let [size (rand-int 11)
          exactly-place (rand-int (- size 1))]
      (is (> (.indexOf (square-with-me size exactly-place) "m") -1)))))


(deftest generate-grid-test
  (testing "a 3x3 square with peach on the top right and me in the center"
    (is (= (generate-grid 3 4 2) ["-" "-" "p"
                                  "-" "m" "-"
                                  "-" "-" "-"])))
  (testing "a 5 square with peach and me in random places"
    (is (= (generate-grid 5 16 4) ["-" "-" "-" "-" "p"
                                  "-" "-" "-" "-" "-"
                                  "-" "-" "-" "-" "-"
                                  "-" "m" "-" "-" "-"
                                  "-" "-" "-" "-" "-"]))))

(deftest next-step-to-the-princess-test
  (testing "it should move right"
    (is (= (next-step-to-the-princess 3 [1 0] "---mp----") "RIGHT")))
  (testing "it should move left"
    (is (= (next-step-to-the-princess 3 [1 2] "----pm---") "LEFT")))
  (testing "it should move up"
    (is (= (next-step-to-the-princess 3 [2 1] "----p--m-") "UP")))
  (testing "it should move down"
    (is (= (next-step-to-the-princess 3 [0 1] "-m--p----") "DOWN"))))
