import unittest

from probs.prob02_algospot_pi.pi import sameNumber, subSameNumber


class SameNumberTestCase(unittest.TestCase):
    def test_sameNumber_1(self):
        self.assertEqual(sameNumber('111'), True)

    def test_sameNumber_2(self):
        self.assertEqual(sameNumber('1111'), True)

    def test_sameNumber_3(self):
        self.assertEqual(sameNumber('11111'), True)

    def test_sameNumber_4(self):
        self.assertEqual(sameNumber('222'), True)

    def test_sameNumber_5(self):
        self.assertEqual(sameNumber('221'), False)

    def test_sameNumber_6(self):
        self.assertEqual(sameNumber('2221'), False)

    def test_sameNumber_7(self):
        self.assertEqual(sameNumber('22221'), False)




class SubSameNumberTestCase(unittest.TestCase):
    def test_subSameNumber_1(self):
        self.assertEqual(subSameNumber('222111', 3), True)

    def test_subSameNumber_2(self):
        self.assertEqual(subSameNumber('222211', 3), False)

    def test_subSameNumber_3(self):
        self.assertEqual(subSameNumber('221111', 4), True)

    def test_subSameNumber_4(self):
        self.assertEqual(subSameNumber('222111', 4), False)

    def test_subSameNumber_5(self):
        self.assertEqual(subSameNumber('221111', 5), False)

    def test_subSameNumber_6(self):
        self.assertEqual(subSameNumber('211111', 5), True)

