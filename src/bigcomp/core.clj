(ns bigcomp.core
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

(def path (io/resource "config.edn"))
(def m (-> path slurp edn/read-string))
