from unittest import TestCase

from probs.prob12_tomato.tomato import get_will_be_ripen_tomatos,\
    str2int_array, get_around_tomatos_will_be_ripen


def convert_raw_iceberg_map_into_array(raw_map):
    converted_map = []
    for each_raw_map in raw_map.rstrip().split("\n"):
        converted_map.append(str2int_array(each_raw_map))

    return converted_map


class UnitTestCase(TestCase):
    def test_get_will_be_ripen_tomatos(self):
        raw_map = """\
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1
"""
        given_map = convert_raw_iceberg_map_into_array(raw_map)

        expected = [
            [2, 5],
            [3, 4]
        ]

        self.assertEqual(expected, get_will_be_ripen_tomatos(given_map))

    def test_get_will_be_ripen_tomatos_2(self):
        raw_map = """\
1 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1
"""
        given_map = convert_raw_iceberg_map_into_array(raw_map)

        expected = [
            [2, 5],
            [3, 4],
            [0, 1],
            [1, 0]
        ]

        self.assertEqual(expected.sort(),
                         get_will_be_ripen_tomatos(given_map).sort())

    def test_get_around_tomatos_will_be_ripen(self):
        raw_map = """\
        0 0 0 0 0 0
        0 0 0 0 0 0
        0 0 0 0 0 0
        0 0 0 0 0 1
        """
        given_map = convert_raw_iceberg_map_into_array(raw_map)
        given_tomato = [3, 5]

        expected = [
            [2, 5],
            [3, 4]
        ]

        self.assertEqual(expected,
                         get_around_tomatos_will_be_ripen(given_map,
                                                          given_tomato))
