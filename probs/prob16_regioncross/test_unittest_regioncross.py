from unittest import TestCase

from probs.prob16_regioncross.regioncross import sort_two_value


class UnitTestCase(TestCase):
    def test_sort_two_value(self):
        result = sort_two_value(-1, 0)
        expected = (-1, 0)
        self.assertEqual(expected, result)
