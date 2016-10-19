(ns rp.json.geo-json-test
  (:require [rp.json.geo-json :refer :all]
            [clojure.test :refer :all]
            [clojure.spec :as s]
            [rp.json.geo-json-spec]))

(deftest test-geo-json-feature
  (let [feature {:longitude -175.02
                 :latitude 30.3453
                 :properties {:propertyname "Overlook at Cambridge"
                              :listingid "143958"}}]
    (is (s/valid? :geo-json/feature (geo-json-feature feature)))))

(deftest test-geo-json-feature-collection
  (let [features [{:longitude -175.02
                   :latitude 30.3453
                   :properties {:propertyname "Overlook at Cambridge"
                                :listingid "143958"}}
                  {:longitude -123.51
                   :latitude 35.0032
                   :properties {:listingid "34432"
                                :propertyname "The Gorge at Walden Pond"}}
                  {:longitude -145.242
                   :latitude 33.5523
                   :properties {:listingid "7324"
                                :propertyname "The Villas at Kenny's House"}}]]
    (is (s/valid? :geo-json/feature-collection
                  (geo-json-feature-collection (mapv geo-json-feature features))))))
