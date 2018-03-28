# import io
# import unittest
# from unittest.mock import patch
#
# from probs.prob08_coloringtree.coloringtree import main, \
#     convert_raw_into_coloring_graph, minimum_coloring_cost
#
# """
# 예제 입력 1
# 8
# 1 2
# 3 1
# 1 4
# 5 6
# 1 5
# 5 7
# 5 8
# 예제 출력 1
# 11
#
# """
#
#
# class ColoringTestCase(unittest.TestCase):
#     def test_something(self):
#         self.assertEqual(True, True)
#
#     @patch('sys.stdout', new_callable=io.StringIO)
#     def test_end2end_1(self, captured_output):
#         raw_input = """\
# 8
# 1 2
# 3 1
# 1 4
# 5 6
# 1 5
# 5 7
# 5 8
# """
#         user_input = raw_input.split("\n")
#
#         with patch('builtins.input', side_effect=user_input):
#             main()
#             output = captured_output.getvalue()
#             output = output.rstrip()
#
#         self.assertEqual("11", output)
#
#     @patch('sys.stdout', new_callable=io.StringIO)
#     def test_end2end_2(self, captured_output):
#         raw_input = """\
# 8
# 1 2
# 3 1
# 1 4
# 5 6
# 1 5
# 5 7
# 5 8
# """
#         user_input = raw_input.split("\n")
#
#         with patch('builtins.input', side_effect=user_input):
#             main()
#             output = captured_output.getvalue()
#             output = output.rstrip()
#
#         self.assertEqual("11", output)
#
#
# class ColoringUnitTestCase(unittest.TestCase):
#     def test_execute_melt_1(self):
#         raw_coloring_graph = """\
# 1 2
# 3 1
# 1 4
# 5 6
# 1 5
# 5 7
# 5 8
# """
#         splitted = raw_coloring_graph.rstrip().split("\n")
#         connection_count = len(splitted)
#         color_count = connection_count + 1
#         coloring_graph = convert_raw_into_coloring_graph(splitted,
#                                                          connection_count)
#
#         self.assertEqual(11,
#                          minimum_coloring_cost(coloring_graph, color_count))
