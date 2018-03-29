from unittest import TestCase


# def convert_raw_map_into_array(raw_map):
#     converted_map = []
#     for each_raw_map in raw_map.rstrip().split("\n"):
#         converted_map.append(str2int_array(each_raw_map))
#
#     return converted_map
from probs.prob13_finalrank.finalrank import make_graph_table


class UnitTestCase(TestCase):
    def test_make_graph_table(self):
        expected = [
            [0, 0, 0, 0, 0],
            [1, 0, 0, 1, 0],
            [1, 1, 0, 1, 0],
            [1, 0, 0, 0, 0],
            [1, 1, 1, 1, 0]
        ]
        self.assertEqual(expected, make_graph_table([
            5, 3, 2, 4, 1
        ]))
