(ns leiningen.test.git-version-test
  (:require
   [clojure.test :refer :all]
   [leiningen.versionator :refer :all]))

(deftest version-test
  (is (= "1.0.0" (re-find #"\d+.\d+.\d+" (get-version {}))))
  (is (= "7.8.9" (re-find #"\d+.\d+.\d+"
                          (get-version {:versionator
                                        {:version {:command ["echo" "v7.8.9-g123"]}}}))))
  )
