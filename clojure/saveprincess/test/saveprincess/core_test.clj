(ns saveprincess.core-test
  (:require [clojure.test :refer :all]
            [saveprincess.core :refer :all]))

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
          grid "p---m----"]
      (is (= (path-to-princess size grid) '("LEFT" "UP")))))
  (testing "princess is on the top right"
    (let [size 5 
          grid "----p--m-------"]
      (is (= (path-to-princess size grid) '("RIGHT" "RIGHT" "UP" "UP")))))
  (testing "princess is on the bottom left"
    (let [size 7 
          grid "----------m---p------"]
      (is (= (path-to-princess size grid) '("LEFT" "LEFT" "LEFT" "DOWN" "DOWN" "DOWN")))))
  (testing "princess is on the bottom right"
    (let [size 3
          grid "----m---p"]
      (is (= (path-to-princess size grid) '("RIGHT" "DOWN"))))))
