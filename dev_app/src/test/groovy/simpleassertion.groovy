import spock.lang.Specification

class simpleassertion  extends Specification {
    def "should be a simple assertion"() {
        expect:
        1 == 1
    }
}