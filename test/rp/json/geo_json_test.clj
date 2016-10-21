(ns rp.json.geo-json-test
  (:require [rp.json.geo-json :refer :all]
            [clojure.test :refer :all]
            [clojure.spec :as s]
            [rp.json.geo-json-spec]))

(deftest test-feature
  (let [point {:longitude -175.02
               :latitude 30.3453
               :properties {:id "143958"
                            :name "Overlook at Cambridge"}}]
    (is (s/valid? :geo-json/feature (feature point)))))

(deftest test-geo-json-feature-collection
  (let [points [{:longitude -175.02
                 :latitude 30.3453
                 :properties {:id "143958"
                              :name "Overlook at Cambridge"}}
                {:longitude -123.51
                 :latitude 35.0032
                 :properties {:id "34432"
                              :name "The Gorge at Walden Pond"}}
                {:longitude -145.242
                 :latitude 33.5523
                 :properties {:id "7324"
                              :name "The Villas at Kenny's House"}}]]
    (is (s/valid? :geo-json/feature-collection
                  (feature-collection (mapv feature points))))))
