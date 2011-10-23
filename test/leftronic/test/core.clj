(ns leftronic.test.server
    (:use [leftronic.core])
    (:use [fm util])
    (:use [clojure.test]))

(deftest carga-todos
	  (is (false-on-exception carga-nss)))