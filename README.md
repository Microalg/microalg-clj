# MicroAlg

<a href="https://travis-ci.org/Microalg/microalg-clj" style="float:right;">
<img src="https://travis-ci.org/Microalg/microalg-clj.svg?branch=master"></a>

Clojure implementation of the [MicroAlg](http://microalg.info) language.

This is a work in progress, not close to be usable yet.

# Usage

## Execute a file

Please run

    java -jar microalg-XXX-standalone.jar test.malg

## REPL

To get a REPL, either:

* `lein repl`,
* double-click the `.jar`,
* `java -jar microalg-XXX-standalone.jar`.

The last two will provide you with a graphical REPL (thanks to
[swingrepl](https://clojars.org/swingrepl) or rather
[uk.org.russet/swingrepl](https://clojars.org/uk.org.russet/swingrepl)).

# Discrepancies

* `=/` is `n=`
