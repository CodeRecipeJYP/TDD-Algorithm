import io
import unittest
from unittest.mock import patch

from probs.prob07_iceberg.iceberg import main, str2int_array, execute_melt

"""
5 7
0 0 0 0 0 0 0
0 2 4 5 3 0 0
0 3 0 2 5 2 0
0 7 6 2 4 0 0
0 0 0 0 0 0 0
예제 출력 1
2


"""


class IcebergTestCase(unittest.TestCase):
    def test_something(self):
        self.assertEqual(True, True)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_end2end_1(self, captured_output):
        raw_input = """\
5 7
0 0 0 0 0 0 0
0 2 4 5 3 0 0
0 3 0 2 5 2 0
0 7 6 2 4 0 0
0 0 0 0 0 0 0
"""
        user_input = raw_input.split("\n")

        with patch('builtins.input', side_effect=user_input):
            main()
            output = captured_output.getvalue()
            output = output.rstrip()

        self.assertEqual("2", output)


def convert_raw_iceberg_map_into_array(raw_iceberg_map):
    iceberg_map = []
    for each_raw_map in raw_iceberg_map.rstrip().split("\n"):
        iceberg_map.append(str2int_array(each_raw_map))

    return iceberg_map


class IcebergUnitTestCase(unittest.TestCase):
    def test_execute_melt_1(self):
        raw_iceberg_map = """\
0 0 0 0 0 0 0
0 2 4 5 3 0 0
0 3 0 2 5 2 0
0 7 6 2 4 0 0
0 0 0 0 0 0 0
"""

        expected_raw_iceberg_map = """\
0 0 0 0 0 0 0
0 0 2 4 1 0 0
0 1 0 1 5 0 0
0 5 4 1 2 0 0
0 0 0 0 0 0 0
        """
        expected_iceberg_map =\
            convert_raw_iceberg_map_into_array(expected_raw_iceberg_map)

        iceberg_map = convert_raw_iceberg_map_into_array(raw_iceberg_map)

        self.assertEqual(expected_iceberg_map, execute_melt(iceberg_map))

    def test_execute_melt_2(self):
        raw_iceberg_map = """\
0 0 0 0 0 0 0
0 0 2 4 1 0 0
0 1 0 1 5 0 0
0 5 4 1 2 0 0
0 0 0 0 0 0 0
"""

        expected_raw_iceberg_map = """\
0 0 0 0 0 0 0
0 0 0 2 0 0 0
0 0 0 0 4 0 0
0 3 2 0 0 0 0
0 0 0 0 0 0 0
        """

        expected_iceberg_map =\
            convert_raw_iceberg_map_into_array(expected_raw_iceberg_map)

        iceberg_map = convert_raw_iceberg_map_into_array(raw_iceberg_map)

        self.assertEqual(expected_iceberg_map, execute_melt(iceberg_map))
